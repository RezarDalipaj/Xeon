package de.dlh.lhind.ecohack.model.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionnaireDto {
    @NotNull
    @NotEmpty
    private List<ResultDto> results;
}
