import java.util.*;

class Tasklistapplication {
    public static void main(String[] args) {
        Tasklist ts = new Tasklist();
        Scanner sc = new Scanner(System.in);
        ts.display();
        
        while (true) {
            System.out.println("Select Option");
            int ch = sc.nextInt();
            sc.nextLine();  
            
            switch (ch) {
                case 1:
                    System.out.println("Enter Task Name");
                    String name = sc.nextLine(); 
                    ts.addTask(name);
                    break;
                case 2:
                    if (!ts.isEmpty()) {
                        System.out.println("Enter task Number to remove:");
                        int num = sc.nextInt();
                        if (ts.isValid(num)) {
                            ts.removeTask(num);
                        } else {
                            System.out.println("Invalid Task Number");
                        }
                    } else {
                        System.out.println("No Task to Remove");
                    }
                    break;
                case 3:
                    if (!ts.isEmpty()) {
                        ts.listTasks();
                    } else {
                        System.out.println("No Tasks to List");
                    }
                    break;
                case 4:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }
    }
}

class Tasklist {
    public ArrayList<String> arr = new ArrayList<>();

    public void display() {
        System.out.println("Tasklist Application");
        System.out.println("1.Add Task");
        System.out.println("2.Remove Task");
        System.out.println("3.List Tasks");
        System.out.println("4.Quit");
    }

    public void addTask(String name) {
        arr.add(name);
    }

    public void removeTask(int num) {
        arr.remove(num - 1);
        System.out.println("Task is Removed");
    }

    public void listTasks() {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println((i + 1) + "." + arr.get(i));
        }
    }

    public boolean isEmpty() {
        return arr.isEmpty();
    }

    public boolean isValid(int num) {
        return num >= 1 && num <= arr.size();
    }
}
