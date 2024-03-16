package frogpay.com.testefrog.entity.users;

import jakarta.validation.constraints.NotNull;

public record RegisterDTO(@NotNull String username, @NotNull String password,@NotNull UserRole role) {
}