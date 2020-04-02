package com.traq.mongo.hadoop.common;

import com.mchange.v2.log.MLog;
import com.mchange.v2.log.MLogger;
import com.mchange.v2.log.NameTransformer;

public class AppLog extends MLog {

    NameTransformer transformer;
    @Override
    public MLogger getMLogger(String name) {
        MLogger out;
        if (transformer == null) {
            out = instance().getMLogger(name);
        } else {
            String xname = transformer.transformName(name);
            if (xname != null) {
                out = instance().getMLogger(xname);
            } else {
                out = instance().getMLogger(name);
            }
        }

        return out;
    }

    @Override
    public MLogger getMLogger(Class cl) {
        MLogger out;
        if (transformer == null) {
            out = instance().getMLogger(cl);
        } else {
            String xname = transformer.transformName(cl);
            if (xname != null) {
                out = instance().getMLogger(xname);
            } else {
                out = instance().getMLogger(cl);
            }
        }

        return out;
    }

    @Override
    public MLogger getMLogger() {
        MLogger out;
        if (transformer == null) {
            out = instance().getMLogger();
        } else {
            String xname = transformer.transformName();
            if (xname != null) {
                out = instance().getMLogger(xname);
            } else {
                out = instance().getMLogger();
            }
        }

        return out;
    }
}
