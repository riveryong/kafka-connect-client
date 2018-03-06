package org.sourcelab.kafka.connect.apiclient.request.post;

import com.sun.xml.internal.rngom.util.Uri;

import java.io.IOException;

public class PostConnectorTaskRestart implements PostRequest<Boolean> {
    private final String connectorName;
    private final int taskId;

    public PostConnectorTaskRestart(final String connectorName, final int taskId) {
        if (connectorName == null) {
            throw new NullPointerException("connectorName parameter may not be null!");
        }
        this.connectorName = connectorName;
        this.taskId = taskId;
    }

    @Override
    public String getApiEndpoint() {
        return "/connectors/" + Uri.escapeDisallowedChars(connectorName) + "/tasks/" + taskId + "/restart";
    }

    @Override
    public Object getRequestBody() {
        return "";
    }

    @Override
    public Boolean parseResponse(final String responseStr) throws IOException {
        return true;
    }

}