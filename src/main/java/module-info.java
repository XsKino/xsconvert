module com.xsconvert.convert {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
//    requires eu.hansolo.tilesfx;

    opens com.xsconvert.convert to javafx.fxml;
    exports com.xsconvert.convert;
}