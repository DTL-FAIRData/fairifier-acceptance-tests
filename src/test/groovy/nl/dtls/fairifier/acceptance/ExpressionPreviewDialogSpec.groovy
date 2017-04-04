package nl.dtls.fairifier.acceptance

import geb.spock.GebReportingSpec

class ExpressionPreviewDialogSpec extends GebReportingSpec {
    def "navigate to preview dialog and check the expected value"() {
        when:
        go "/"
        $("li.action-area-tab", 0).click()
        report "create project tab"
        
        and:
        $("div.create-project-ui-source-selection-tab", 2).click()
        report "clipboard tab"
        
        and:
        $("textarea#default-importing-clipboard-textarea") << """\
            id,name,value
            1,test,17
            2,foo,42
            3,bar,94
            """.stripIndent()
        report "text input"
        
        and:
        $("div.create-project-ui-source-selection-tab-body.selected form button[bind=nextButton]").click()
        waitFor { $("table.data-table") }
        report "form submit"
        
        and:
        $("div.default-importing-wizard-header button[bind=nextButton]").click()
        waitFor { $("div.data-table-container") }
        report "data-imported"
        
        and:
        $("span.button-menu", text: "RDF").click()
        report "rdf menu opened"
        $("div.menu-container a.menu-item", 0).click()
        report "edit semantic model dialog opened"
        $("a.schema-alignment-node-tag", text: "(row index) URI").click()
        report "row uri dialog opened"
        $("a[bind=rdf_cell_expr_preview]", text: "preview/edit").click()
        report "preview dialog opened"
        
        waitFor { $("div.expression-preview-container") }
        
        then:
        def base = System.getProperty("geb.build.baseUrl")
        $("div.expression-preview-container").$("tr", 1).$("td", 3).text() == "${base}/0"
    }
}
