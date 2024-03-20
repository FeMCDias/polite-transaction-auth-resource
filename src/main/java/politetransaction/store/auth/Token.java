package politetransaction.store.auth;

import lombok.Builder;

@Builder
public record Token (
    String id, 
    String role,
    String name
    ) {
    }
