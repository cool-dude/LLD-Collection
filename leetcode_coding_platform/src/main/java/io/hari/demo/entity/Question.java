package io.hari.demo.entity;
/*Leetcode coding blox coding platform */
import io.hari.demo.constant.Level;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Builder
@Entity
@Table(name = "questions")
public class Question extends BaseEntity{
    String question;

    @Enumerated(EnumType.STRING)
    Level level;

    BigInteger score;
}
