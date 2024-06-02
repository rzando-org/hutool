/*
 * Copyright (c) 2023 looly(loolly@aliyun.com)
 * Hutool is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *          http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */

package cn.hutool.core.comparator;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.RandomUtil;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Issue3259Test {

	@Test
	public void fieldsComparatorTest() {
		Model x = new Model(1, 1);
		Model y = new Model(1, RandomUtil.randomInt(2, 100));

		Assert.assertTrue(new FieldsComparator<>(Model.class, "a", "b").compare(x, y) < 0);
	}

	@Test
	@Ignore
	public void sortTest() {
		for(int i = 2; i < 5; i++) {
			Model x = new Model(1, 1);
			Model y = new Model(1, i);

			List<Model> all = ListUtil.of(x, y);
			all = CollUtil.sort(new ArrayList<>(all), new FieldsComparator<>(Model.class, "a", "b"));
			System.out.println(all);
		}
	}

	@AllArgsConstructor
	@ToString
	public static class Model {
		public int a;
		public int b;
	}
}
