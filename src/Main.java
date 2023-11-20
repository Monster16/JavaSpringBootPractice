////public class Main {
////    public static void main(String[] args) {
////        System.out.println("Hello world!");
////    }
////}
//
//public class Main {
//
////    static String str2 ="JAVA1";
////    {
////        String str2 = "JAVA2";
////    }
//    public static void main(String[] args) {
//       /*  int x = 5;
//        int y = 10;
//        int z = ++x + y--;
//        System.out.println("x: " + x + " y: " + y + " z: " + z);
//        */
//
//        int Integer = 24;
//        char String = 'I';
//
//
//
//
////        String str2 = "JAVA3";
//        System.out.println(Integer);
//        System.out.println(String);
//
//
//
//    }
//}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Define a list of ProjectDto objects
        List<ProjectDto> projectList = new ArrayList<>();
        projectList.add(new ProjectDto(1, "Project A", "John, Alice"));
        projectList.add(new ProjectDto(2, "Project B", "Jane"));
        projectList.add(new ProjectDto(3, "Project C", "Bob, Carol, David"));

        // Print project IDs and names with reviewer names as a list
        for (ProjectDto project : projectList) {
            System.out.println("Project ID: " + project.getProjectId() + " | Project Name: " + project.getProjectName());
            List<String> reviewers = new ArrayList<>();
            String[] reviewerArray = project.getReviewers().split(",");
            for (String reviewer : reviewerArray) {
                reviewers.add(reviewer.trim());
            }
            System.out.println("Reviewers: " + reviewers);
            System.out.println();
        }
    }
}

class ProjectDto {
    private int projectId;
    private String projectName;
    private String reviewers;

    public ProjectDto(int projectId, String projectName, String reviewers) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.reviewers = reviewers;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getReviewers() {
        return reviewers;
    }
}


