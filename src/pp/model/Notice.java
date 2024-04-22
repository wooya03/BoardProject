package pp.model;

public class Notice extends Board{
    public Notice(int id, String writer, String title, String content) {
        super(id, writer, title, content);
    }

    @Override
    public void print() {
        System.out.println("=============================");
        System.out.println("[" + getId() + "-공지사항] : " + getTitle() + " - " + getWriter());
        System.out.println(getContent());
        System.out.println("=============================");
    }
}
