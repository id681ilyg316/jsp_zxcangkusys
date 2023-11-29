## 本项目实现的最终作用是基于JSP实现的在线仓库管理系统
## 分为1个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 仓库管理员登录
 - 出库和入库管理
 - 管理员管理
 - 财务信息管理
 - 货品&类别信息管理
 - 采购信息管理
## 数据库设计如下：
# 数据库设计文档

**数据库名：** zxcangkusys

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [tb_accounting](#tb_accounting) |  |
| [tb_accounting_add](#tb_accounting_add) |  |
| [tb_admin](#tb_admin) |  |
| [tb_goods](#tb_goods) |  |
| [tb_goodstype](#tb_goodstype) |  |
| [tb_purchase](#tb_purchase) |  |
| [tb_stockin](#tb_stockin) |  |
| [tb_stockout](#tb_stockout) |  |

**表名：** <a id="tb_accounting">tb_accounting</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | accounting_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | accounting_guid |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  3   | accounting_name |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  4   | accounting_money |   double   | 23 |   0    |    N     |  N   |       |   |
|  5   | accounting_date |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  6   | accounting_used |   double   | 23 |   0    |    Y     |  N   |   0    |   |
|  7   | accounting_balance |   double   | 23 |   0    |    Y     |  N   |   0    |   |
|  8   | accounting_level |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  9   | accounting_desc |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="tb_accounting_add">tb_accounting_add</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | accounting_add_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | accounting_add_guid |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  3   | accounting_guid |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  4   | accounting_add_date |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  5   | accounting_add_money |   double   | 23 |   0    |    N     |  N   |       |   |

**表名：** <a id="tb_admin">tb_admin</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | admin_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | admin_guid |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  3   | admin_name |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  4   | admin_username |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  5   | admin_pwd |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  6   | admin_phone |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  7   | admin_cardid |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  8   | admin_authority |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  9   | admin_date |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  10   | admin_del |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  11   | admin_sex |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="tb_goods">tb_goods</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | goods_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | goods_guid |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  3   | goods_name |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  4   | type_guid |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  5   | goods_price |   float   | 13 |   0    |    Y     |  N   |   NULL    | 商品价格  |
|  6   | goods_supplier |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  7   | goods_place |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  8   | goods_date |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  9   | goods_retailprice |   float   | 13 |   0    |    Y     |  N   |   NULL    |   |
|  10   | goods_desc |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="tb_goodstype">tb_goodstype</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | type_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | type_guid |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  3   | type_name |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  4   | type_date |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | type_desc |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="tb_purchase">tb_purchase</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | purchase_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | purchase_guid |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  3   | goods_guid |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  4   | purchase_num |   int   | 10 |   0    |    N     |  N   |       |   |
|  5   | purchase_total |   double   | 23 |   0    |    Y     |  N   |   NULL    |   |
|  6   | purchase_date |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  7   | accounting_guid |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  8   | purchase_desc |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="tb_stockin">tb_stockin</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | stockin_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | stockin_guid |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  3   | goods_guid |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  4   | stockin_num |   int   | 10 |   0    |    N     |  N   |       |   |
|  5   | stockin_date |   varchar   | 255 |   0    |    N     |  N   |       |   |

**表名：** <a id="tb_stockout">tb_stockout</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | stockout_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | stockout_guid |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  3   | goods_guid |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  4   | stockin_guid |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  5   | stockout_date |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  6   | stockout_num |   int   | 10 |   0    |    N     |  N   |       |   |
|  7   | stockout_people |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  8   | stockout_money |   double   | 23 |   0    |    N     |  N   |       |   |
|  9   | stockout_profit |   double   | 23 |   0    |    N     |  N   |       |   |
|  10   | stockout_unitprice |   double   | 23 |   0    |    Y     |  N   |   NULL    |   |

**运行不出来可以微信 javape 我的公众号：源码码头**
