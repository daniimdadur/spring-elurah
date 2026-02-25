package com.gentara.elurah.master.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RwReq {
    @NotBlank(message = "name is required")
    @Length(min = 4, max = 20)
    private String name;
    @NotBlank(message = "address is required")
    private String address;
}
