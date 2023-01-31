package co.develhope.swagger2.controllers;

import co.develhope.swagger2.entities.ArithmeticOperation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping
    public String getWelcomeMathMsg(){
        return "welcome math class";
    }
    @GetMapping ("/division-info")
   public ArithmeticOperation division(){
        String[] properties = {"divisione per 1"," divisione per 0" };

        return new ArithmeticOperation("division",0,"dividendo / divisore = risultato",properties);
    }
    @GetMapping ("/moltiplication")
    public int getMoltiplication(@RequestParam(required = true)int operandi1,@RequestParam(required = true) int operandi2){
        return operandi1 * operandi2;

    }
    @GetMapping(value = "/square/{n}")
    @ApiOperation(value = "Execute a square of a given number", notes = "Gives back to the user the result of multiplication of the given number times itself")
    public int getSquare(@ApiParam(value = "The number that needs to be squared") @PathVariable() int n){
        return n * n;
    }
}
