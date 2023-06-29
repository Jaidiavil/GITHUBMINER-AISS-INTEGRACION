package aiss.GitHubMiner.Except;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "Proyecto no encontrado")
public class  ProjectNotFound extends Exception{
}

