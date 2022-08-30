package com.mao.log.record.starter.diff;//package com.ydm.common.log.starter.diff;

import de.danielbechler.diff.node.DiffNode;

public interface IDiffItemsToLogContentService {

    String toLogContent(DiffNode diffNode, final Object o1, final Object o2);
}
