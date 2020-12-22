const sizes = ['iphone-6', 'iphone-x', 'ipad-mini'];

sizes.forEach(size => {
    describe(`User can open mobile menu on ${size}`, () => {
        beforeEach(() => {
            cy.visit('/')
            cy.viewport(size)
        })

        it.skip(`should show mobile menu on button click`, () => {
            cy.get('[data-test=mobile-menu]').should('not.exist')
            cy.get('[data-test=menu-button').click()
            cy.get('[data-test=mobile-menu]').should('be.visible')
        });

        it(`should show mobile menu on dashboard`, () => {
            cy.createRandomAccountAndLogin();

            cy.get('[data-test=mobile-menu]').should('not.be.visible')
            cy.get('[data-test=menu-button').click()
            cy.get('[data-test=mobile-menu]').should('be.visible')
        });
    });
})
