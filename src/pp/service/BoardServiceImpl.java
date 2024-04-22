package pp.service;

import pp.model.Board;

import java.util.ArrayList;

public class BoardServiceImpl implements BoardService{
    public static int uniqueid = 0;
    ArrayList<Board> arraylist = new ArrayList<Board>();
    @Override
    public int uniqueId() {
        return uniqueid++;
    }


    @Override
    public void register(Board board){
        arraylist.add(board);
    }

    @Override
    public ArrayList<Board> getAll() {
        return arraylist;
    }

    @Override
    public Board getList(int id) {
        return null;
    }

    @Override
    public void remove(int id) {
        arraylist.remove(id);
    }

    @Override
    public void modify(Board board) {
        arraylist.set(board.getId(), board);
    }
}
