package ntut.csie.sslab.kanban.workflow.usecase;

public class Workflow1 {
    private final String id;
    private final String name;

    public Workflow1(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
