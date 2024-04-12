package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor


public class Offer {
    private int id;

    @Size(min=2, max=100, message = "Name must be between 2 and 100 chars")  // @Valid : name에 대한 제약조건(2이상 100이하의 chars)
    private String name;

    @Email(message="Please provide a valid email address")  // @Valid : Email에 대한 제약조건
    @NotEmpty(message="The email address cannot be empty")
    private String email;

    @Size(min=5, max=100, message="Text must be between 5 and 100 chars")  // @Valid : text에 대한 제약조건
    private String text;
}
