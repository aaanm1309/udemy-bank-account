package br.com.adrianomenezes.account.cmd.api.controllers;

import br.com.adrianomenezes.account.cmd.api.commands.DepositFundsCommand;
import br.com.adrianomenezes.account.cmd.api.commands.WithdrawFundsCommand;
import br.com.adrianomenezes.account.common.dto.BaseResponse;
import br.com.adrianomenezes.cqrs.core.exceptions.AggregateNotFoundException;
import br.com.adrianomenezes.cqrs.core.infrastructure.CommandDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api/v1/withDrawFunds")
public class WithDrawFundsController {
    private final Logger logger = Logger.getLogger(DepositFundsController.class.getName());

    @Autowired
    private CommandDispatcher commandDispatcher;

    @PutMapping(path = "/{id}")
    public ResponseEntity<BaseResponse> WithDrawFunds(@PathVariable(value = "id") String id,
                                                      @RequestBody WithdrawFundsCommand command){
        try {
            command.setId(id);
            commandDispatcher.send(command);
            return new ResponseEntity<>(new BaseResponse("WithDraw funds request completed successfully"), HttpStatus.OK);

        } catch (IllegalStateException | AggregateNotFoundException e){
            logger.log(Level.WARNING, MessageFormat.format("Client made a bad request - {0}", e.toString()));
            return new ResponseEntity<>(new BaseResponse(e.toString()), HttpStatus.BAD_REQUEST);

        } catch (Exception e){
            var safeErrorMessage = MessageFormat.format("Error while processing request to withdraw funds from bank account for id - {0}", id);
            logger.log(Level.SEVERE,safeErrorMessage , e);
            return new ResponseEntity<>(new BaseResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
