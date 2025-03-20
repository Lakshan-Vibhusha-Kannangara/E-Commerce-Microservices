package com.vibhusha.dto;


import com.vibhusha.model.Address;
import lombok.Builder;

@Builder
public record CustomerResponse(String id, String firstName, String email, Address address) {
}
