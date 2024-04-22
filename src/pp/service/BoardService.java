package pp.service;

import java.util.ArrayList;
import pp.model.Board;

public interface BoardService {
    int uniqueId();
    void register(Board board);
    ArrayList<Board> getAll();
    Board getList(int id);
    void remove(int id);
    void modify(Board board);

}
