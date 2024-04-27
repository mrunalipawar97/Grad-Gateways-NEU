package com.gradgateways.neu.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
*
* @author mrunalipawar
* class : GradGatewaysErrorController
*/

@Controller
@RequestMapping("/error")
public class GradGatewaysErrorController implements ErrorController {

	@GetMapping()
    public String handleError() {
        return "error encountered";
    }
}
