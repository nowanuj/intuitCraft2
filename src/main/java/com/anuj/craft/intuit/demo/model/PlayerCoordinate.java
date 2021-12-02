package com.anuj.craft.intuit.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerCoordinate {

    private List<Integer> positions;
    private String firstPlayer;
    private String secondPlayer;
}
