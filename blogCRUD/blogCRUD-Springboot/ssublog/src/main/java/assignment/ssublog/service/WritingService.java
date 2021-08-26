package assignment.yourssu.service;

import assignment.yourssu.common.MessageDto;
import assignment.yourssu.domain.BlogWriting;

import java.util.List;
import java.util.Optional;

public interface WritingService {

    BlogWriting saveWriting(BlogWriting blogWriting);

    BlogWriting findWritingById(long writingId);

    List<BlogWriting> findWritingByTitle(String writingTitle);

    List<BlogWriting> findWritingByAuthor(String blog_writing_author);

    List<BlogWriting> findAllWritings();

    BlogWriting updateWriting(BlogWriting blogWriting);

    MessageDto deleteWritingById(Long id);

}
