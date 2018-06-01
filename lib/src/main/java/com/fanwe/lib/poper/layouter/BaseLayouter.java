/*
 * Copyright (C) 2017 zhengjun, fanwe (http://www.fanwe.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fanwe.lib.poper.layouter;

import com.fanwe.lib.poper.Poper;

public abstract class BaseLayouter implements Poper.Layouter
{
    private boolean mIsDebug;


    public final boolean isDebug()
    {
        return mIsDebug;
    }

    public BaseLayouter setDebug(boolean debug)
    {
        mIsDebug = debug;
        return this;
    }

    protected String getDebugTag()
    {
        return getClass().getSimpleName();
    }
}