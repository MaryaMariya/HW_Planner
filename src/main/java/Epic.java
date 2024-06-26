public class Epic extends Task{
    private String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

       @Override
    public boolean matches(String query) {
        for (String sabtask : subtasks){
            if (sabtask.contains(query)){
                return true;
            }
        }
        return false;
    }

}
