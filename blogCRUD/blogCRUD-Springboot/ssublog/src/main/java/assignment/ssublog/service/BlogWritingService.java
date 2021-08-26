package assignment.yourssu.service;

import assignment.yourssu.common.MessageDto;
import assignment.yourssu.domain.BlogWriting;
import assignment.yourssu.repository.WritingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BlogWritingService implements WritingService {

    private final WritingRepository writingRepository;

    @Override
    @Transactional
    public BlogWriting saveWriting(BlogWriting blogWriting) {
        return writingRepository.save(blogWriting);
    }

    @Override
    public BlogWriting findWritingById(long writingId) {
        return writingRepository.findById(writingId);
    }

    @Override
    public List<BlogWriting> findWritingByTitle(String writingTitle) {
        return writingRepository.findByTitle(writingTitle);
    }

    @Override
    public List<BlogWriting> findWritingByAuthor(String writingAuthor) {
        return writingRepository.findByAuthor(writingAuthor);
    }

    @Override
    public List<BlogWriting> findAllWritings() {
        return writingRepository.findAll();
    }

    @Override
    @Transactional
    public BlogWriting updateWriting(BlogWriting blogWriting) {

        return writingRepository.update(blogWriting);
    }

    @Override
    @Transactional
    public MessageDto deleteWritingById(Long writingId) {
        return writingRepository.deleteById(writingId);
    }

}
