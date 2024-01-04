package io.camunda.example;

import io.camunda.connector.api.annotation.OutboundConnector;
import io.camunda.connector.api.error.ConnectorException;
import io.camunda.connector.api.outbound.OutboundConnectorContext;
import io.camunda.connector.api.outbound.OutboundConnectorFunction;
import io.camunda.connector.generator.java.annotation.ElementTemplate;
import io.camunda.example.db.DatabaseManager;
import io.camunda.example.dto.MyConnectorRequest;
import io.camunda.example.dto.MyConnectorResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@OutboundConnector(
    name = "MYCONNECTOR",
    inputVariables = {"authentication", "jdbc", "command"},
    //type = "io.camunda:template:1")
        type = "io.camunda:connector-jdbc:1")
/*@ElementTemplate(
    id = "io.camunda.connector.Template.v1",
    name = "Template connector",
    version = 1,
    description = "Describe this connector",
    icon = "icon.svg",
    documentationRef = "https://docs.camunda.io/docs/components/connectors/out-of-the-box-connectors/available-connectors-overview/",
    propertyGroups = {
      @ElementTemplate.PropertyGroup(id = "authentication", label = "Authentication"),
      @ElementTemplate.PropertyGroup(id = "compose", label = "Compose")
    },
    inputDataClass = MyConnectorRequest.class)

 */
public class MyConnectorFunction implements OutboundConnectorFunction {

  private static final Logger LOGGER = LoggerFactory.getLogger(MyConnectorFunction.class);

  //private Map<MyConnectorRequest, DatabaseManager> databaseManagers = new HashMap<>();

  @Override
  public MyConnectorResult execute(OutboundConnectorContext context) {
    LOGGER.info("Vars are "+context.getJobContext().getVariables());
    final var connectorRequest = context.bindVariables(MyConnectorRequest.class);
    return executeConnector(connectorRequest);
  }

  private MyConnectorResult executeConnector(final MyConnectorRequest connectorRequest) {
    // TODO: implement connector logic
    LOGGER.info("Executing my connector with request {}", connectorRequest);

    String message = connectorRequest.command().sql();
    if (message != null && message.toLowerCase().startsWith("fail")) {
      throw new ConnectorException("FAIL", "My property started with 'fail', was: " + message);
    }

    /*
    // Get DB Manager
    DatabaseManager db = databaseManagers.get(connectorRequest);

    if(db == null) {
      db = new DatabaseManager(connectorRequest);
      databaseManagers.put(connectorRequest, db);
    }

    switch (connectorRequest.command().commandType()) {

      case "selectOne":
        return db.selectOne(connectorRequest.command().sql(), connectorRequest.command().params());

      case "selectList":
        return db.selectList(connectorRequest.command().sql(), connectorRequest.command().params());

      case "selectMap":
        return db.selectMap(connectorRequest.command().sql(), connectorRequest.command().params(), "placeholder");

      case "insert":
      case "update":
      case "delete":
        return db.update(connectorRequest.command().sql(), connectorRequest.command().params());

      default: throw new UnsupportedOperationException("The command type" + connectorRequest.command().commandType() + " is not currently supported");

    }

     */

    return new MyConnectorResult("Message received: " + message);
  }
}
