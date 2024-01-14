<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <meta charset="UTF-8"/>
                <title>Rooms</title>
            </head>
            <body>
                <a href="/xsl/patient">Show patients</a>
            </body>
            <body>
                <a href="/xsl/hospital">Show hospitals</a>
            </body>
        </html>
        <table border="1" style="margin-top: 5px">
            <tr bgcolor="#CCCCCC">
                <td>
                    <strong>id_hospital</strong>
                </td>
                <td>
                    <strong>id_room</strong>
                </td>
            </tr>
            <xsl:for-each select="ArrayList/item">
                <tr>
                    <td>
                        <xsl:value-of select="id_hospital"/>
                    </td>
                    <td>
                        <xsl:value-of select="id_room"/>
                    </td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
</xsl:stylesheet>