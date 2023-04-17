module bep.chatapp.client {
    requires javafx.controls;
    requires javafx.fxml;


    opens bep.chatapp.client to javafx.fxml;
    exports bep.chatapp.client;
}