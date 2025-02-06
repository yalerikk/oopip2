module com.example.demo2 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.laba4_lera to javafx.fxml;
    exports com.example.laba4_lera;
    exports com.example.laba4_lera.Services;
    opens com.example.laba4_lera.Services to javafx.fxml;
    exports com.example.laba4_lera.Models;
    opens com.example.laba4_lera.Models to javafx.fxml;
    exports com.example.laba4_lera.Controllers;
    opens com.example.laba4_lera.Controllers to javafx.fxml;
    exports com.example.laba4_lera.Exception;
    opens com.example.laba4_lera.Exception to javafx.fxml;
}