package pp;

import pp.management.BoardManagementSystem;
import pp.management.ManagementSystem;
import pp.service.BoardServiceImpl;

public class Process {
    public static void main(String[] args) {
        ManagementSystem managementSystem = new BoardManagementSystem(new BoardServiceImpl());
        managementSystem.execute();
    }
}
