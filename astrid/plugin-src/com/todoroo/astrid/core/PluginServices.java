package com.todoroo.astrid.core;

import com.todoroo.andlib.service.Autowired;
import com.todoroo.andlib.service.DependencyInjectionService;
import com.todoroo.andlib.service.ExceptionService;
import com.todoroo.astrid.dao.Database;
import com.todoroo.astrid.service.AddOnService;
import com.todoroo.astrid.service.MetadataService;
import com.todoroo.astrid.service.TaskService;

/**
 * Utility class for getting dependency-injected services from plugins
 *
 * @author Tim Su <tim@todoroo.com>
 *
 */
public final class PluginServices {

    @Autowired
    TaskService taskService;

    @Autowired
    Database database;

    @Autowired
    ExceptionService exceptionService;

    @Autowired
    MetadataService metadataService;

    @Autowired
    AddOnService addOnService;

    private static PluginServices instance;

    private PluginServices() {
        DependencyInjectionService.getInstance().inject(this);
    }

    private synchronized static PluginServices getInstance() {
        if(instance == null)
            instance = new PluginServices();
        return instance;
    }

    public static TaskService getTaskService() {
        getInstance().database.openForWriting();
        return getInstance().taskService;
    }

    public static ExceptionService getExceptionService() {
        return getInstance().exceptionService;
    }

    public static MetadataService getMetadataService() {
        getInstance().database.openForWriting();
        return getInstance().metadataService;
    }

    public static AddOnService getAddOnService() {
        return getInstance().addOnService;
    }
}