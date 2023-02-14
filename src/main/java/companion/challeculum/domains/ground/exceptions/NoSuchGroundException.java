package companion.challeculum.domains.ground.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="Cannot find the ground you requested.")
public class NoSuchGroundException  extends RuntimeException {}
