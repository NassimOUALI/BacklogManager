package org.example.backlogmanager.service;

import org.example.backlogmanager.dto.ProjectCreateDTO;
import org.example.backlogmanager.entities.ProductOwner;
import org.example.backlogmanager.entities.Project;
import org.example.backlogmanager.repository.ProjectRepository;
import org.example.backlogmanager.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository; // Fake Repository

    @Mock
    private UserRepository userRepository;       // Fake User Repository

    @InjectMocks
    private ProjectService projectService;       // The real service logic

    @Test
    void shouldCreateProject_WhenValid() {
        // Arrange (Prepare the data)
        ProjectCreateDTO dto = new ProjectCreateDTO();
        dto.setNom("Scrum App");
        dto.setProductOwnerId(1L);

        ProductOwner mockPO = new ProductOwner();
        mockPO.setId(1L);

        // Define behavior for the Fakes
        when(projectRepository.existsByName("Scrum App")).thenReturn(false);
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockPO));
        when(projectRepository.save(any(Project.class))).thenAnswer(i -> i.getArguments()[0]);

        // Act (Run the logic)
        Project result = projectService.createProject(dto);

        // Assert (Verify the result)
        assertNotNull(result);
        assertEquals("Scrum App", result.getNom());
        assertEquals(mockPO, result.getProductOwner());

        // Verify that the repository save method was actually called
        verify(projectRepository).save(any(Project.class));
    }
}