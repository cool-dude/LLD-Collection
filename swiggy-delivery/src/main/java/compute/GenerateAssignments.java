package compute;

/*swiggy delivery executive assignment distance*/
import java.util.List;

public interface GenerateAssignments<Entity1, Entity2, Result1> {
    List<Result1> generateAssignments(List<Entity1> entity1s, List<Entity2> entity2s);
}
