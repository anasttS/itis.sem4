package stateMachine.parameter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Parameter {
    private Integer developerId;
    private Integer testerId;
    private String error;
    private String text;

}
