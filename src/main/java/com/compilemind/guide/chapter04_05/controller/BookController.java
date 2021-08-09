package com.compilemind.guide.chapter04_05.controller;

import com.compilemind.guide.chapter04_05.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("books")
public class BookController {

    private final List<Book> bookList;

    /**
     * 构造函数
     * 内部进行bookList初始化操作，便于下面的测试
     */
    public BookController() {
        int count = 3;
        this.bookList = new ArrayList<>(count);
        Random random = new Random();
        for (int idx = 0; idx < count; idx++) {

            Book book = new Book();
            book.setId(Integer.toString(idx));
            book.setName("book@" + idx);
            book.setPrice(random.nextInt(100) + 1);

            this.bookList.add(book);
        }
    }

    /**
     * GET /books
     * 返回所有的书籍信息
     */
    @GetMapping
    public List<Book> getBookList() {
        return bookList;
    }

    /**
     * GET /books/{id}
     * 根据书籍ID，得到对应的书籍信息
     * @param id 书籍ID
     * @return 书籍
     */
    @GetMapping("{id}")
    public Book getBookById(@PathVariable("id") String id) {
        Optional<Book> first = this.bookList
                .stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
        return first.orElse(null);
    }

    /**
     * POST /books
     * 添加书籍信息
     * 需要注意的是，入参Book需要添加注解@RequestBody，才能通过HTTP JSON形式传入
     * @param book 希望新增的书籍信息
     */
    @PostMapping
    public void addBook(@RequestBody Book book) {
        if (book == null) {
            System.out.println("请求数据book为空，未进行添加");
            return;
        }
        // 服务端生成ID
        String nextId = Integer.toString(this.bookList.size());
        book.setId(nextId);
        this.bookList.add(book);
    }

    /**
     * PUT /books/{id}
     * 更新指定ID书籍的信息，
     * 需要注意的是，入参Book需要添加注解@RequestBody，才能通过HTTP JSON形式传入
     * @param id 希望更新的书籍信息
     * @param book 希望更新的书籍信息
     */
    @PutMapping("{id}")
    public void updateBook(@PathVariable("id") String id, @RequestBody Book book) {
        if (book == null || id == null) {
            System.out.println("请求数据book为空或指定书籍id为空，终止更新");
            return;
        }
        Optional<Book> first = this.bookList
                .stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
        if (first.isPresent()) {
            Book exist = first.get();
            exist.setName(book.getName());
            exist.setPrice(book.getPrice());
        }
    }

    /**
     * DELETE /books/{id}
     * 根据书籍ID删除对应的书籍信息
     * @param id 待删除的书籍ID
     */
    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable("id") String id) {
        if (id == null || id.trim().equals("")) {
            return;
        }
        Optional<Book> existBook = this.bookList
                .stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
        existBook.ifPresent(this.bookList::remove);
    }
}
