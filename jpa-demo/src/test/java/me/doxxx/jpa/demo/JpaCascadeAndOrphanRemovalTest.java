package me.doxxx.jpa.demo;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ContextConfiguration(classes = {JpaDemoApplication.class, Parent.class, Child.class})
public class JpaCascadeAndOrphanRemovalTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    @DisplayName("부모 엔티티를 저장하면 자식 엔티티도 저장되어야 한다.")
    public void testCascadePersist() {
        Parent parent = new Parent();
        Child child = new Child();
        child.setParent(parent);
        parent.getChildren().add(child);

        entityManager.persist(parent);
        entityManager.flush();

        List<Child> children = entityManager.createQuery("from Child", Child.class).getResultList();
        assertEquals(1, children.size());
        assertEquals(parent.getId(), children.get(0).getParent().getId());
    }

    @Test
    @DisplayName("부모 엔티티에서 자식 엔티티를 제거하면 자식 엔티티가 삭제되어야 한다.")
    public void testOrphanRemoval() {
        Parent parent = new Parent();
        Child child = new Child();
        child.setParent(parent);
        parent.getChildren().add(child);

        entityManager.persist(parent);
        entityManager.flush();

        parent.getChildren().remove(child);
        entityManager.flush();

        List<Child> children = entityManager.createQuery("from Child", Child.class).getResultList();
        assertTrue(children.isEmpty());
    }

    @Test
    @DisplayName("부모 엔티티 삭제 시 자식 엔티티도 삭제되어야 한다.")
    public void testCascadeRemove() {
        Parent parent = new Parent();
        Child child = new Child();
        child.setParent(parent);
        parent.getChildren().add(child);

        entityManager.persist(parent);
        entityManager.flush();

        entityManager.remove(parent);
        entityManager.flush();

        List<Child> children = entityManager.createQuery("from Child", Child.class).getResultList();
        assertTrue(children.isEmpty());
    }
}
