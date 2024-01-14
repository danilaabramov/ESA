<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <meta charset="UTF-8"/>
                <title>Orders</title>
            </head>
            <body>
                <a href="/xsl/orders">Show orders</a>
            </body>
        </html>
        <table border="1" style="margin-top: 5px">
            <tr bgcolor="#CCCCCC">
                <td>
                    <strong>id_hospital</strong>
                </td>
                <td>
                    <strong>id_card</strong>
                </td>
                <td>
                    <strong>id_room</strong>
                </td>
                <td>
                    <strong>full_name</strong>
                </td>
                <td>
                    <strong>gender</strong>
                </td>
                <td>
                    <strong>years</strong>
                </td>
            </tr>
            <xsl:for-each select="List/item">
                <tr>
                    <td>
                        <xsl:value-of select="id_hospital"/>
                    </td>
                    <td>
                        <xsl:value-of select="id_card"/>
                    </td>
                    <td>
                        <xsl:value-of select="id_room"/>
                    </td>
                    <td>
                        <xsl:value-of select="full_name"/>
                    </td>
                    <td>
                        <xsl:value-of select="gender"/>
                    </td>
                    <td>
                        <xsl:value-of select="years"/>
                    </td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
</xsl:stylesheet>