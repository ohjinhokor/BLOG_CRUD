package assignment.yourssu.repository;

import assignment.yourssu.common.MessageDto;
import assignment.yourssu.domain.BlogWriting;

import java.util.List;
import java.util.Optional;

public interface WritingRepository {
    BlogWriting save(BlogWriting blogWriting);

    BlogWriting findById(long writingId);

    List<BlogWriting> findByTitle(String blog_writing_title);

    List<BlogWriting> findByAuthor(String blog_writing_author);

    List<BlogWriting> findAll();

    BlogWriting update(BlogWriting blogWriting);

    MessageDto deleteById(Long id);

}
