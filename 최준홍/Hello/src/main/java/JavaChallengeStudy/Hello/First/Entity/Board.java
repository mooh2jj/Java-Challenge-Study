//package com.dsg.springbootboardexample.domain.board.entity;
//
//import com.dsg.springbootboardexample.domain.board.dto.BoardCreateRequestDto;
//import com.dsg.springbootboardexample.domain.board.dto.BoardRequestDto;
//import com.dsg.springbootboardexample.domain.tag.entity.TagBridge;
//import com.dsg.springbootboardexample.infra.entity.BaseTimeEntity;
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Entity
//@Getter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Table(
//        name = "boards", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
//)
//@ToString(exclude = {"comments", "tagBridges"})
//public class Board extends BaseTimeEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(length = 100, nullable = false)
//    private String title;
//
//    @Column(length = 1500, nullable = false)
//    private String content;
//
//    private String filename;
//
//    private String filepath;
//
//    @Column(length = 50, nullable = false)
//    private String writer;
//
//    @Setter
//    @OneToMany(mappedBy = "board")
//    private List<TagBridge> tagBridges = new ArrayList<>();
//
//    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Comment> comments = new ArrayList<>();
//
//    @Builder
//    public Board(String title, String content, String filename, String filepath, String writer, List<Comment> comments) {
//        this.title = title;
//        this.content = content;
//        this.filename = filename;
//        this.filepath = filepath;
//        this.writer = writer;
//        this.comments = comments;
//    }
//
//    public static Board of(BoardRequestDto boardRequestDto) {
//        return Board.builder()
//                .title(boardRequestDto.getTitle())
//                .content(boardRequestDto.getContent())
//                .build();
//    }
//
//    public static Board from(BoardCreateRequestDto requestDto) {
//        return Board.builder()
//                .title(requestDto.getTitle())
//                .content(requestDto.getContent())
//                //                .filename(requestDto.getFileName())
//                //                .filepath(requestDto.getFilePath())
//                .writer(requestDto.getWriter())
//                .build();
//    }
//
//    public void update(BoardRequestDto reqDto) {
//        this.title = reqDto.getTitle();
//        this.content = reqDto.getContent();
//    }
//
//    public void changeFile(String fileName, String filePath) {
//        this.filename = fileName;
//        this.filepath = filePath;
//    }
//
//    public String getTagJoinList() {
//        return tagBridges.stream()
//                .map(tagBridge -> tagBridge.getTag().getTitleKor())
//                .collect(Collectors.joining(", "));
//    }
//}