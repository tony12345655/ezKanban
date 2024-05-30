package ntut.csie.sslab.kanban.workflow.usecase;

import ntut.csie.sslab.ddd.usecase.cqrs.CqrsOutput;
import ntut.csie.sslab.ddd.usecase.cqrs.ExitCode;

public class CreateWorkflow1UseCase {
    private final workflow1RepositoryInMemory repository;

    public CreateWorkflow1UseCase(workflow1RepositoryInMemory repository){
        this.repository = repository;
    }
    public CqrsOutput execute(CreateWorkflow1Input input){
        Workflow1 workflow1 = new Workflow1(input.id, input.name);
        repository.save(workflow1);
        return CqrsOutput.create().setId(workflow1.getId()).setExitCode(ExitCode.SUCCESS);
    }
}
