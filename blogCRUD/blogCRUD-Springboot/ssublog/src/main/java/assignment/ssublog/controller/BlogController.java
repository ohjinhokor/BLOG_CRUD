package assignment.yourssu.controller;

import assignment.yourssu.common.MessageDto;
import assignment.yourssu.domain.BlogWriting;
import assignment.yourssu.service.WritingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/ssu")
@RequiredArgsConstructor
public class BlogController {

    private final WritingService writingService;

    @PostMapping(path="blog")
    @ResponseBody
    public BlogWriting saveBlogWriting(@RequestBody BlogWriting blogWriting){
        return writingService.saveWriting(blogWriting);
    }

    @GetMapping(path="blog/id/{writingId}")
    @ResponseBody
    public BlogWriting findBlogWritingById(@PathVariable(name = "writingId") long writingId){
        System.out.println(1111);
        return writingService.findWritingById(writingId);
    }

    @GetMapping(path="blog/title/{writingTitle}")
    @ResponseBody
    public List<BlogWriting> findBlogWritingByTitle(@PathVariable(name = "writingTitle") String writingTitle){
        return writingService.findWritingByTitle(writingTitle);
    }

    @GetMapping(path="blog/author/{writingAuthor}")
    @ResponseBody
    public List<BlogWriting> findBlogWritingByAuthor(@PathVariable(name = "writingAuthor") String writingAuthor){
        return writingService.findWritingByAuthor(writingAuthor);
    }

    @GetMapping(path="blog")
    @ResponseBody
    public List<BlogWriting> findAllBlogWritings(){
        return writingService.findAllWritings();
    }

    @PatchMapping(path="blog")
    @ResponseBody
    public BlogWriting updateBlogWriting(@RequestBody BlogWriting blogWriting){
        return writingService.updateWriting(blogWriting);
    }

    @DeleteMapping(path="blog/{writingId}")
    @ResponseBody
    public MessageDto deleteBlogWriting(@PathVariable(name = "writingId") Long writingId){
        return writingService.deleteWritingById(writingId);
    }
}















