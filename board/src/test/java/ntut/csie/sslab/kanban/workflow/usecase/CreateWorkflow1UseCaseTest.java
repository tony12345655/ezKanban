package ntut.csie.sslab.kanban.workflow.usecase;
import ntut.csie.sslab.ddd.usecase.cqrs.CqrsOutput;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateWorkflow1UseCaseTest {

    @Test
    public void create_workflow1_case_test(){
        workflow1RepositoryInMemory createWorkflow1RepositoryInMemory = new workflow1RepositoryInMemory();
        CreateWorkflow1UseCase createWorkflow1UseCase = new CreateWorkflow1UseCase(createWorkflow1RepositoryInMemory);
        CreateWorkflow1Input input = new CreateWorkflow1Input();
        input.id = "1";
        input.name = "workflow1";
        CqrsOutput output = createWorkflow1UseCase.execute(input);
        assertNotNull(output.getId());
        assertEquals("1", createWorkflow1RepositoryInMemory.findById(output.getId()).get().getId());

    }
}
