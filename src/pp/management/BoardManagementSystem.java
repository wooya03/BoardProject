package pp.management;

import pp.model.Board;
import pp.model.Event;
import pp.model.Notice;
import pp.service.BoardService;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardManagementSystem implements ManagementSystem {

    private BoardService boardService;
    private Scanner scanner;
    public BoardManagementSystem(BoardService boardService) {
        System.out.println("[BoardManagementSystem 준비]");
        this.boardService = boardService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.println("[BoardManagementSystem 실행]");
        while(true){
            System.out.println("=============================");
            System.out.println("1. 게시글등록");
            System.out.println("2. 게시글조회");
            System.out.println("3. 게시글수정");
            System.out.println("4. 게시글삭제");
            System.out.println("5. 시스템종료");
            System.out.println("=============================");
            System.out.println("메뉴를 선택하세요.");
            System.out.println("=============================");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("게시글 등록을 선택하셨습니다...");
                    register();
                    break;
                case 2:
                    System.out.println("게시글 조회를 선택하셨습니다...");
                    list();
                    break;
                case 3:
                    System.out.println("게시글 수정을 선택하셨습니다...");
                    modity();
                    break;
                case 4:
                    System.out.println("게시글 삭제를 선택하셨습니다...");
                    remove();
                    break;
                case 5:
                    System.out.println("시스템을 종료합니다...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 1부터 5까지의 숫자를 선택하세요.");
                    break;
            }
        }
    }

    private void register() {
        System.out.println("[게시글 등록]");
        System.out.print("게시글 공지사항[1], 이벤트[2] : ");
        String type = scanner.next();
        System.out.print("제목 : ");
        String title = scanner.next();
        System.out.print("내용 : ");
        String content = scanner.next();
        System.out.print("작성자 : ");
        String writer = scanner.next();
        Board board;
        if (type.equals("1")) {
            board = new Notice(boardService.uniqueId(), writer, title, content);
        } else {
            board = new Event(boardService.uniqueId(), writer, title, content);
        }
        boardService.register(board);
    }

    public void list() {
        System.out.println("[게시글 조회]");
        System.out.print("전체[0], 공지사항[1], 이벤트[2] : ");
        String type = scanner.next();
        for (Board b : boardService.getAll()) {
            if (type.equals("1") && b instanceof Notice) {
                b.print();
            } else if (type.equals("2") && b instanceof Event) {
                b.print();
            } else if (type.equals("0")) {
                b.print();
            }
        }
    }
    public void remove(){
        System.out.print("게시글 ID : ");
        int id = scanner.nextInt();
        boardService.remove(id);
    }

    public void modity(){
        System.out.print("공지사항[1], 이벤트[2] : ");
        String type = scanner.next();
        System.out.print("게시글 ID : ");
        int id = scanner.nextInt();
        System.out.print("제목 : ");
        String title = scanner.next();
        System.out.print("내용 : ");
        String content = scanner.next();
        System.out.print("작성자 : ");
        String writer = scanner.next();
        Board board;
        if(type.equals("1")){
            board = new Notice(id, writer, title, content);
        } else {
            board = new Event(id, writer, title, content);
        }
        boardService.modify(board);
    }
}
