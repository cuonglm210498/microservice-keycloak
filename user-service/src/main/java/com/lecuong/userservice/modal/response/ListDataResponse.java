package com.lecuong.userservice.modal.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
public class ListDataResponse<T> {
    private long totalPage;
    private List<T> data;
}
