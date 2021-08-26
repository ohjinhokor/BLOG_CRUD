package assignment.yourssu.repository;

import assignment.yourssu.common.MessageDto;
import assignment.yourssu.domain.BlogWriting;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BlogWritingRepository implements WritingRepository{

    private final EntityManager em;

    @Override
    public BlogWriting save(BlogWriting blogWriting) {
        em.persist(blogWriting);
        return blogWriting;
    }

    @Override
    public BlogWriting findById(long writingId) {
        return em.createQuery("select w from BlogWriting w where w.id = :id", BlogWriting.class)
                .setParameter("id", writingId)
                .getSingleResult();
}

    @Override
    public List<BlogWriting> findByTitle(String title) {
        return em.createQuery("select w from BlogWriting w where w.title = :title", BlogWriting.class)
                .setParameter("title", title)
                .getResultList();
    }

    @Override
    public List<BlogWriting> findByAuthor(String writingAuthor) {
        return em.createQuery("select w from BlogWriting w where w.author = :author", BlogWriting.class)
                .setParameter("author", writingAuthor)
                .getResultList();
    }

    @Override
    public List<BlogWriting> findAll() {
        return em.createQuery("select m from BlogWriting m", BlogWriting.class)
                .getResultList();
    }

    @Override
    public BlogWriting update(BlogWriting blogWriting) {

        BlogWriting beforeUpdateBlogWriting = findById(blogWriting.getId());
        beforeUpdateBlogWriting.setAuthor(blogWriting.getAuthor());
        beforeUpdateBlogWriting.setPosting_body(blogWriting.getPosting_body());
        beforeUpdateBlogWriting.setTitle(blogWriting.getTitle());

        return findById(blogWriting.getId());
    }

    @Override
    public MessageDto deleteById(Long id) {
        BlogWriting blogWriting = findById(id);
        System.out.println(111111);
        em.remove(blogWriting);
        System.out.println(3535353);
        MessageDto md = new MessageDto("deleted successfully");
        System.out.println("md.getMessage() = " + md.getMessage());
        return md;
    }

}
