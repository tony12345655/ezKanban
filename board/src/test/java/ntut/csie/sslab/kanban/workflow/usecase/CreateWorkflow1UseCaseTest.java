package ntut.csie.sslab.kanban.workflow.usecase;
import com.google.common.eventbus.Subscribe;
import ntut.csie.sslab.ddd.adapter.gateway.GoogleEventBusAdapter;
import ntut.csie.sslab.ddd.usecase.DomainEventBus;
import ntut.csie.sslab.ddd.usecase.cqrs.CqrsOutput;
import ntut.csie.sslab.kanban.workflow.entity.event.Workflow1Created;
import ntut.csie.sslab.kanban.workflow.adapter.out.repository.Workflow1RepositoryInMemory;
import ntut.csie.sslab.kanban.workflow.entity.Workflow1;
import ntut.csie.sslab.kanban.workflow.usecase.port.in.create.CreateWorkflow1Input;
import ntut.csie.sslab.kanban.workflow.usecase.service.CreateWorkflow1Service;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateWorkflow1UseCaseTest {
    @Test
    public void create_workflow1_use_case_test(){
        Workflow1RepositoryInMemory createWorkflow1RepositoryInMemory = new Workflow1RepositoryInMemory();
        DomainEventBus eventBus = new GoogleEventBusAdapter();
        CreateWorkflow1Service createWorkflow1UseCase = new CreateWorkflow1Service(createWorkflow1RepositoryInMemory, eventBus);
        CreateWorkflow1Input input = new CreateWorkflow1Input();
        input.id = "1";
        input.name = "workflow1";
        CqrsOutput output = createWorkflow1UseCase.execute(input);
        assertNotNull(output.getId());
        assertEquals("1", createWorkflow1RepositoryInMemory.findById(output.getId()).get().getId());
        assertEquals("workflow1", createWorkflow1RepositoryInMemory.findById(output.getId()).get().getName());
    }
    @Test
    public void  workflow1_created_domain_event_test(){
        Workflow1 workflow1 = new Workflow1("1", "workflow1");
        Workflow1Created domainEvent = (Workflow1Created) workflow1.getDomainEvents().get(0);
        assertEquals(workflow1.getId(), domainEvent.workFlow1Id());
        assertEquals(workflow1.getName(), domainEvent.workFlowName());
    }

    @Test
    public void workflow1_listener_test(){
        Workflow1RepositoryInMemory workflow1RepositoryInMemory = new Workflow1RepositoryInMemory();
        DomainEventBus eventBus = new GoogleEventBusAdapter();
        CreateWorkflow1Service createWorkflow1UseCase = new CreateWorkflow1Service(workflow1RepositoryInMemory, eventBus);
        MockEventListener mockEventListener = new MockEventListener();
        eventBus.register(mockEventListener);
        CreateWorkflow1Input input = new CreateWorkflow1Input();
        input.id = "!";
        input.name = "workflow1";
        createWorkflow1UseCase.execute(input);
        assertTrue(mockEventListener.getCalled());
    }

    private static class MockEventListener {
        private boolean called = false;
        @Subscribe
        public void whenWorkflow1Created(Workflow1Created workflow1Created){
            called = true;
        }

        public boolean getCalled(){
            return called;
        }
    }

}
