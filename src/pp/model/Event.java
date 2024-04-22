package pp.model;

public class Event extends Board{
    public Event(int id, String writer, String title, String content){
        super(id, writer, title, content);
    }
    @Override
    public void print() {
        System.out.println("=============================");
        System.out.println("[" + getId() + "-이벤트] : " + getTitle() + " - " + getWriter());
        System.out.println(getContent());
        System.out.println("=============================");
    }
}
